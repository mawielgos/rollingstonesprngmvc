/**
 * 
 */
package com.rollingstone.orderprocessing.web.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.rollingstone.orderprocessing.model.Customer;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;

/**
 * @author samallick
 *
 */
public class CustomerRssFeedView extends AbstractRssFeedView {
	
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
		
		feed.setTitle("Customer");
		feed.setDescription("Customer RSS Feed");
		feed.setLink("http://google.com");
		
		super.buildFeedMetadata(model, feed, request);
	}
	

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.feed.AbstractRssFeedView#buildFeedItems(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Item> items = null;
		List<Customer> customers = (List) model.get("customers");
		if(customers != null){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			items = new ArrayList<Item>();
			for (Customer customer : customers) {
				if(customer != null){
					Content content = new Content();
					Item item = new Item();
					item.setContent(content);
					items.add(item);
					
					String value = customer.getCustomerId() +" "+ customer.getBalance();
					content.setValue(value);
					item.setPubDate(customer.getMemberSince());
					item.setAuthor(customer.getCustomerName());
				}
			}
		}		
		return items;
	}

}
