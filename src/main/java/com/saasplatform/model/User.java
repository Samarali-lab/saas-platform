import javax.persistence.*;  
import java.time.LocalDateTime;  
  
@Entity  
@Table(name = "users")  
public class User {  
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;  
  
	@Column(nullable = false, unique = true)  
	private String email;  
  
	@Column(nullable = false)  
	private String password;  
  
	@Column(nullable = false)  
	private String firstName;  
  
	@Column(nullable = false)  
	private String lastName;  
  
	@Column(nullable = false, unique = true)  
	private String username;  
  
	private String profilePicture;  
	private String phone;  
	private String company;  
  
	@Enumerated(EnumType.STRING)  
	private UserRole role;  
  
	@Enumerated(EnumType.STRING)  
	private UserStatus status;  
  
	@Column(name = "created_at", updatable = false)  
	private LocalDateTime createdAt;  
  
	@Column(name = "updated_at")  
	private LocalDateTime updatedAt;  
  
	@Column(name = "last_login")  
	private LocalDateTime lastLogin;  
  
	// Getters and Setters  
	public Long getId() { return id; }  
	public void setId(Long id) { this.id = id; }  
	public String getEmail() { return email; }  
	public void setEmail(String email) { this.email = email; }  
	public String getPassword() { return password; }  
	public void setPassword(String password) { this.password = password; }  
	public String getFirstName() { return firstName; }  
	public void setFirstName(String firstName) { this.firstName = firstName; }  
	public String getLastName() { return lastName; }  
	public void setLastName(String lastName) { this.lastName = lastName; }  
	public String getUsername() { return username; }  
	public void setUsername(String username) { this.username = username; }  
	public String getProfilePicture() { return profilePicture; }  
	public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }  
	public String getPhone() { return phone; }  
	public void setPhone(String phone) { this.phone = phone; }  
	public String getCompany() { return company; }  
	public void setCompany(String company) { this.company = company; }  
	public UserRole getRole() { return role; }  
	public void setRole(UserRole role) { this.role = role; }  
	public UserStatus getStatus() { return status; }  
	public void setStatus(UserStatus status) { this.status = status; }  
	public LocalDateTime getCreatedAt() { return createdAt; }  
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }  
	public LocalDateTime getUpdatedAt() { return updatedAt; }  
	public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }  
	public LocalDateTime getLastLogin() { return lastLogin; }  
	public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }  
}  
  
public enum UserRole {
    ADMIN,
    USER
}
  
public enum UserStatus {
    ACTIVE,
    INACTIVE
}