import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiaryManageImpl implements DiaryManage {
	private List<DiaryT> list;
	
	public DiaryManageImpl() {
		list = new ArrayList<>();
	}
	
	@Override
	public void add(DiaryT d) {
		list.add(d);
	}

	@Override
	public List<DiaryT> list() {
		return list;
	}

	@Override
	public void edit(LocalDate day, String content) {
		int index = list.indexOf(new DiaryT(day));
		if (index >= 0) {
			DiaryT d = list.get(index);
			d.setContent(content);
		}
	}

	@Override
	public void deleteFirst() {
		if (!list.isEmpty()) {
			list.remove(0);
		}
	}
}










