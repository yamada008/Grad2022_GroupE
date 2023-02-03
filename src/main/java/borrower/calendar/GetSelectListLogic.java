package borrower.calendar;

import borrower.advise.Advise;

public class GetSelectListLogic {
	public Advise execute(int Id, String strDate) {
		SelectDAO dao = new SelectDAO();
		Advise select = dao.select(Id, strDate);
		return select;
	}
}
