package csc584.bean;

public class ProfileBean {
    private int id;
    private String name;
    private String studentID;
    private String program;
    private String email;
    private String hobbies;
    private String intro;

    // ID getter/setter
    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }

    public String getStudentID() { 
        return studentID; 
    }
    
    public void setStudentID(String studentID) { 
        this.studentID = studentID; 
    }

    public String getProgram() { 
        return program; 
    }
    
    public void setProgram(String program) { 
        this.program = program; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getHobbies() { 
        return hobbies; 
    }
    
    public void setHobbies(String hobbies) { 
        this.hobbies = hobbies; 
    }

    public String getIntro() { 
        return intro; 
    }
    
    public void setIntro(String intro) { 
        this.intro = intro; 
    }
}
