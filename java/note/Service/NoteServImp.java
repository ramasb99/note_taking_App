package note.Service;

import java.util.List;

import note.Model.Note;
import note.Repository.NoteRepo;
import note.Repository.NoteRepoImp;

public class NoteServImp implements NoteService {

	NoteRepo repo=new NoteRepoImp();
	@Override
	public boolean AddNote(Note n) {
		return repo.AddNote(n);
	}
	@Override
	public List<Note> getNotes(int id) {
		// TODO Auto-generated method stub
		return repo.getNotes(id);
	}
	@Override
	public String getCatName(int id) {
		// TODO Auto-generated method stub
		return repo.getCatName(id);
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return repo.deleteNote(id);
	}
	@Override
	public Note getData(int uid) {
		// TODO Auto-generated method stub
		return repo.getNote(uid);
	}

}
