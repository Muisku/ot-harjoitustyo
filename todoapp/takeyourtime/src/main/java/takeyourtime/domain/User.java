
package takeyourtime.domain;

public class User {
    
    private Integer id;
    private String name;
    private String username;
    
    public User(Integer id, String name, String username) {
        
        this.id = id;
        this.name = name;
        this.username = username;

    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean equals(Object obj) {
        User other = (User)obj;
        return username.equals(other.username);
    }
}
