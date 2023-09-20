package note.Service;

import note.Model.User;
import note.Repository.UserRepo;
import note.Repository.UserRepoImp;

public class UserServImp implements UserService{

	UserRepo repo = new UserRepoImp();
	
	@Override
	public User regUser(User user) {
		return repo.regUser(user);
	}

	@Override
	public User isValid(User user) {
		return repo.isValid(user);
	}

	@Override
	public String getNameById(User user) {
		return repo.getNameById(user);
	}

	@Override
	public boolean verifyEmail(User u) {
		// TODO Auto-generated method stub
		return repo.verifyEmail(u);
	}

	@Override
	public boolean forgotPass(User u) {
		// TODO Auto-generated method stub
		return repo.forgotPass(u);
	}

	@Override
	public User getDetailsById(User u) {
		return repo.getDataById(u);
	}

	@Override
	public boolean UpdateUser(User u) {
		return repo.UpdateUser(u);
	}

	@Override
	public boolean UpdateEmail(User u) {
		// TODO Auto-generated method stub
		return repo.UpdateEmail(u);
	}
	
	

}
