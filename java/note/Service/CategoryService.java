package note.Service;

import java.util.List;

import note.Model.Category;

public interface CategoryService {
	
	public boolean addCategory(Category c,int id);
	public List<Category> getCategory(int id);
	public List<Category> getCategoryByName(String name,int uid);
	public boolean getCatName(String name,int id);
    public String getCategoryUp(int cid,int uid);
    public boolean updateCat(Category c,int uid);
    
   
    
	
}
