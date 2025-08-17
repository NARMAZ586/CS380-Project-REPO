package application;

import Company.products;
/**
InterfaceListener
Date of code: 8/14/25
This interface handles all of the interface interactions
This includes things like onActionListener
@author Matthew
*/
public interface InterfaceListener {
	/**
	 * Listener for the product item
	 * @param item for the listener
	 */
	public void onActionListener(products.product item);
}
