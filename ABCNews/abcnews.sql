-- Tạo Database
CREATE DATABASE AssignmentNews;
GO
USE AssignmentNews;
GO

-- Bảng Categories
CREATE TABLE Categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL
);

INSERT INTO Categories(name) VALUES
('Văn hóa'),
('Pháp luật'),
('Thể thao');

DROP TABLE IF EXISTS Users;
-- Bảng Users
CREATE TABLE Users (
    Id VARCHAR(50) PRIMARY KEY NOT NULL,         
    Password VARCHAR(100) NOT NULL,     
    Fullname NVARCHAR(100) NOT NULL,    
    Birthday DATE,                      
    Gender BIT,                         
    Mobile VARCHAR(20),                 
    Email VARCHAR(100),                 
    Role BIT                            
);

INSERT INTO Users (Id, Password, Fullname, Birthday, Gender, Mobile, Email, Role)
VALUES 
('admin3', '123456', N'Quản trị viên', '1990-01-01', 1, '0901234567', 'admin@example.com', 1),
('pv001', '123456', N'Phóng viên A', '1995-05-05', 1, '0907654321', 'pvA@example.com', 0);

DROP TABLE IF EXISTS News;
CREATE TABLE News (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Image NVARCHAR(200),
    Content NVARCHAR(MAX),
    PostedDate DATETIME DEFAULT GETDATE(),
    Author NVARCHAR(100),
    ViewCount INT DEFAULT 0,
    CategoryId INT FOREIGN KEY REFERENCES Categories(Id),
    Home BIT DEFAULT 0
);





INSERT INTO News(title, image, content, categoryId) VALUES
('Bản tin văn hóa 1','placeholder.jpg','Nội dung văn hóa 1',1),
('Bản tin pháp luật 1','placeholder.jpg','Nội dung pháp luật 1',2),
('Bản tin thể thao 1','placeholder.jpg','Nội dung thể thao 1',3),
('Bản tin văn hóa 2','placeholder.jpg','Nội dung văn hóa 2',1),
('Bản tin pháp luật 2','placeholder.jpg','Nội dung pháp luật 2',2);

-- Bảng Newsletter
CREATE TABLE Newsletter (
    id INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO Newsletter(email) VALUES
('abc@example.com'),
('user@example.com');

SELECT * FROM Newsletter
SELECT * FROM Users
SELECT * FROM News
SELECT * FROM Categories

SELECT Id, Role FROM Users;
SELECT Id, Title, CategoryId FROM News;
SELECT * FROM News ORDER BY Id DESC;
SELECT Id, Title, CategoryId
FROM News
WHERE CategoryId = 1
ORDER BY Id DESC;
SELECT Id, Title, CategoryId, PostedDate FROM News;
