package note.Repository;

import java.util.List;

import note.Model.Note;

public interface NoteRepo {
	public boolean AddNote(Note n);
	public List<Note> getNotes(int id);
	public String getCatName(int id);
	public boolean deleteNote(int id);
	public Note getNote(int uid);
}
