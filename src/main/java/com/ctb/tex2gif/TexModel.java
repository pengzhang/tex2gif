package com.ctb.tex2gif;

public class TexModel {

	public static String getLaTex(String latex, int font_size) {
		if (font_size == 0) {
			font_size = 12;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("\\documentclass["+font_size+"pt]{article}");
		sb.append("\\pagestyle{empty}");
		sb.append("\\begin{document}");
		sb.append("\\begin{displaymath}");
		sb.append(latex);
		sb.append("\\end{displaymath}");
		sb.append("\\end{document}");
		
		return sb.toString();
	}
}
