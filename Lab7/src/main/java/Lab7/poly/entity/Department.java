package Lab7.poly.entity;

public class Department {
    String id;
    String name;
    String Description;
    
    // Constructor không tham số (BẮT BUỘC cho BeanUtils)
    public Department() {
    }
    
    // Constructor có tham số
    public Department(String id, String name, String Description) {
        super();
        this.id = id;
        this.name = name;
        this.Description = Description;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String description) {
        Description = description;
    }
}