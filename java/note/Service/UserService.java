package note.Service;

import note.Model.User;

public interface UserService {

	public User regUser(User user);
	public User isValid(User user);
	public String getNameById(User user);
	public boolean verifyEmail(User u);
	public boolean forgotPass(User u);
	public User getDetailsById(User u);
	public boolean UpdateUser(User u);
	public boolean UpdateEmail(User u);
}
