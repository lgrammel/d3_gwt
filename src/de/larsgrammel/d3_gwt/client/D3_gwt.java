package de.larsgrammel.d3_gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

public class D3_gwt implements EntryPoint {

	public void onModuleLoad() {
		Element parent = RootPanel.getBodyElement();

		// assume this is in a widget class: create DOM element & attach to
		// parent
		Element div = DOM.createDiv();
		parent.appendChild(div);

		// load data from somewhere (here randomly generated)
		double[] data = new double[10];
		for (int i = 0; i < data.length; i++) {
			data[i] = Math.random() + .1;
		}

		// convert data into jsarray (see
		// https://developers.google.com/web-toolkit/doc/latest/DevGuideCodingBasicsJSNI
		// for more documentation on overlay types etc.
		//
		// the idea is that a native js object gets passed into the js code
		// so it runs fairly fast in dev mode
		JsArrayNumber jsData = JavaScriptObject.createArray().cast();
		for (int i = 0; i < data.length; i++) {
			jsData.push(data[i]);
		}

		createBarchart(div, jsData);
	}

	// call d3 with dom element & data
	private native void createBarchart(Element div, JsArrayNumber jsData)/*-{
		$wnd.d3_barchart(div, jsData);
	}-*/;

}