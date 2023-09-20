package note.Service;

import java.util.List;

import note.Model.Note;

public interface NoteService {
	public boolean AddNote(Note n);
	public List<Note> getNotes(int id);
	public String getCatName(int id);
	public boolean delete(int id);
    public Note getData(int uid);
}
