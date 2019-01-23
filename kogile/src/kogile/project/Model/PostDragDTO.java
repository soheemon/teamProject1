package kogile.project.Model;

import java.io.Serializable;

public class PostDragDTO implements Serializable {
	
		private int old_c_no;
		private int new_c_no;
		private int p_no;
		private int c_no;

		public PostDragDTO() {}

		public int getOld_c_no() {
			return old_c_no;
		}

		public void setOld_c_no(int old_c_no) {
			this.old_c_no = old_c_no;
		}

		public int getNew_c_no() {
			return new_c_no;
		}

		public void setNew_c_no(int new_c_no) {
			this.new_c_no = new_c_no;
		}

		public int getP_no() {
			return p_no;
		}

		public void setP_no(int p_no) {
			this.p_no = p_no;
		}

		public int getC_no() {
			return c_no;
		}

		public void setC_no(int c_no) {
			this.c_no = c_no;
		}

		public PostDragDTO(int old_c_no, int new_c_no, int p_no, int c_no) {
			super();
			this.old_c_no = old_c_no;
			this.new_c_no = new_c_no;
			this.p_no = p_no;
			this.c_no = c_no;
		}

}
