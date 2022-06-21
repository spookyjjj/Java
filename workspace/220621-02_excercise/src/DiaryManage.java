import java.time.LocalDate;
import java.util.List;

public interface DiaryManage {
	void add(DiaryT d);
	List<DiaryT> list();
	void edit(LocalDate day, String content);
	void deleteFirst();
}