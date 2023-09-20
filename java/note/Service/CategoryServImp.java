package note.Service;

import java.util.List;

import note.Model.Category;
import note.Model.User;
import note.Repository.CategoryRepo;
import note.Repository.CategoryRepoImp;

public class CategoryServImp implements CategoryService{

	
	CategoryRepo repo=new CategoryRepoImp();
	@Override
	public boolean addCategory(Category c,int id) {
		return repo.addCategory(c, id);
	}
	@Override
	public List<Category> getCategory(int id) {
		return repo.getCategory(id);
	}
	@Override
	public List<Category> getCategoryByName(String name,int uid) {
		return repo.getCategoryByName(name,uid);
	}
	@Override
	public boolean getCatName(String name,int id) {
		return repo.getCatName(name, id);
	}
	@Override
	public String getCategoryUp(int cid, int uid) {
		return repo.getCategoryUp(cid, uid);
	}
	@Override
	public boolean updateCat(Category c, int uid) {
		return repo.updateCat(c, uid);
	}

}
