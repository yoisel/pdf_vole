package com.btr.pdfvole.tree;

import com.btr.pdfvole.INodeViewer;
import com.btr.pdfvole.ResourceManager;
import com.btr.pdfvole.viewer.HtmlNodeViewer;
import com.lowagie.text.pdf.PdfString;

/*****************************************************************************
 * String tree node for the PDF tree.
 * 
 * @author  Bernd Rosstauscher (pdfvole@rosstauscher.de)
 ****************************************************************************/

public class StringTreeNode extends AbstractPdfTreeNode {

	private PdfString value;
	
	/*************************************************************************
	 * Constructor
	 * @param p0
	 ************************************************************************/
	
	public StringTreeNode(String name, PdfString value) {
		super(name);
		this.value = value;

		setIcon(ResourceManager.getIcon("tree.node.string.icon")); //$NON-NLS-1$
	}

	/*************************************************************************
	 * @see com.btr.pdfvole.tree.AbstractPdfTreeNode#updateViewer(com.btr.pdfvole.INodeViewer)
	 ************************************************************************/
	@Override
	public void updateViewer(INodeViewer viewer) {
		HtmlNodeViewer contentPanel = new HtmlNodeViewer();
		contentPanel.setContent(
				String.format("<html><p>%s</p></html>", this.value)); //$NON-NLS-1$
		
		viewer.setViewer(contentPanel);
	}
	
	/*************************************************************************
	 * calculateSize
	 * @see com.btr.pdfvole.tree.AbstractPdfTreeNode#calculateSize()
	 ************************************************************************/
	@Override
	protected int calculateSize() {
		return PdfSizeCalculator.calculateSize(this.value);
	}
	
}
