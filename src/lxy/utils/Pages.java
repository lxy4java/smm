package lxy.utils;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Pages extends TagSupport {

	private Integer curPage;
	private Integer totalPage;
	private Integer pageSize = 3;
	private Integer totalCount = 0;
	private String formId;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		int pageNumber = 0;
		if (totalPage % pageSize == 0) {
			pageNumber = totalPage / pageSize;
		} else {
			pageNumber = (totalPage / pageSize) + 1;
		}
		if (curPage < 1) {
			curPage = 1;
		}

		try {
			if (pageNumber > 0) {
				out.print("<script type='text/javascript'>"
						+ "function go(pageNum){"
						+ "var f = document.getElementById('"
						+ formId
						+ "');"
						+ "f.action = f.action + '?pageNum=' + pageNum + '&pageSize="
						+ pageSize + "';" + "f.submit();" + "}" + "</script>");

				out.print("<div class='pagination'><ul>");
				int start = 1;
				int end = totalPage;
				for (int i = 4; i >= 1; i--) {
					if ((curPage - i) >= 1) {
						start = curPage - i;
						break;
					}
				}
				for (int i = 4; i >= 1; i--) {
					if ((curPage + i) <= totalPage) {
						end = curPage + i;
						break;
					}
				}
				// ���С��9���Ҳಹ��
				if (end - start + 1 <= 9) {
					Integer padLen = 9 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((end + i) <= totalPage) {
							end = end + i;
							break;
						}
					}
				}

				// �����С��9��ಹ��
				if (end - start + 1 <= 9) {
					Integer padLen = 9 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((start - i) >= 1) {
							start = start - i;
							break;
						}
					}
				}

				if (curPage > 1) {
					if (start > 1) {
						out.print("<li><a href='javascript:go(1)'>��ҳ</a></li>");
					}
					out.print("<li><a href='javascript:go(" + (curPage - 1)
							+ ")'>��һҳ</a></li>");
				}

				for (int i = start; i <= end; i++) {
					if (i == curPage) {
						out.print("<li class='active'><a href='#'>" + i
								+ "</a></li>");
					} else {
						out.print("<li><a href='javascript:go(" + i + ")'>" + i
								+ "</a></li>");
					}
				}
				if (curPage < totalPage) {
					out.print("<li><a href='javascript:go(" + (curPage + 1)
							+ ")'>��һҳ</a></li>");
					if (end < totalPage) {
						out.print("<li><a href='javascript:go(" + totalPage
								+ ")'>βҳ</a></li>");
					}
				}
				out.print("<li><a href='javascript:void(0)'>��" + totalPage
						+ "ҳ" + this.totalCount + "��</a></li>");
				out.print("</ul>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();
	}

	public static Integer getStartIndex(Integer pageNum, Integer pageSize) {
		Integer res = 0;
		if (pageNum > 0) {
			res = (pageNum - 1) * pageSize;
		}
		return res;
	}

}
