package note.Repository;

import note.Model.User;

public interface UserRepo {
	
  public User regUser(User user);
  public User isValid(User user);
  public String getNameById(User user);
  public boolean verifyEmail(User u);
  public boolean forgotPass(User u);
  public User getDataById(User u);
  public boolean UpdateUser(User u);
  public boolean UpdateEmail(User u);
}
