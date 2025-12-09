package Lab7.poly.servlet;

import Lab7.poly.dao.DepartmentDAO;
import Lab7.poly.dao.DepartmentDAOIpml;
import Lab7.poly.entity.Department;
import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet({
        "/department/index",
        "/department/edit/*",
        "/department/create",
        "/department/update",
        "/department/delete",
        "/department/reset"
})
public class DepartmentSevlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Department form = new Department();

        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        DepartmentDAO dao = new DepartmentDAOIpml();
        String path = req.getServletPath();

        if (path.contains("edit")) {
            String id = req.getPathInfo().substring(1);
            form = dao.findById(id);
        } else if (path.contains("create")) {
            dao.create(form);
            form = new Department();
        } else if (path.contains("update")) {
            dao.update(form);
        } else if (path.contains("delete")) {
            dao.deleteById(form.getId());
            form = new Department();
        } else {
            form = new Department();
        }

        req.setAttribute("item", form);

        List<Department> list = dao.findAll();
        req.setAttribute("list", list);

        req.getRequestDispatcher("/Lab7_JSP/Department.jsp").forward(req, resp);
    }
}
