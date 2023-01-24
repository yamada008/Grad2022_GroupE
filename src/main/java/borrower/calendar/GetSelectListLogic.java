package borrower.calendar;

import borrower.advise.Advise;

public class GetSelectListLogic {
	public Advise execute(int strId, String strDate) {
		SelectDAO dao = new SelectDAO();
		Advise select = dao.select(strId, strDate);
		return select;
	}
}
