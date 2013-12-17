/**
 * 
 */
package scribes.community.services;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.core.Response;

import scribes.community.data.Bid;
import scribes.community.data.Service;

import scribes.community.restful.interfaces.IScribesServicesService;
import scribes.community.DAO.ScribesDataManager;





public class ScribesServicesService implements IScribesServicesService {
	private ScribesDataManager sdm = new ScribesDataManager();
	
	@Override
	public List<Service> getAllServices() {
		List<Service> services = new ArrayList<Service>();
		services = sdm.retrieveAllServices();
		return services;
	}
	;
	
	

	@Override
	public Service getServiceById(String serviceId) {
		Service service = null;		
		try {
			service = sdm.getServiceById(serviceId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	@Override
	public Response createService(Service service) {
		String serviceId = sdm.createService(service);
		//System.out.println("Created service");	
		String result = "Service created: " + serviceId + "-" + service;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(201).entity(result).build();    
	}

	@Override
	public Response updateService(String serviceId, Service service) {
		service.setServiceId(serviceId);
		sdm.updateService(service);
		String result = "Service Updated : " + serviceId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}

	@Override
	public Response deleteService(String serviceId) {
		sdm.deleteService(serviceId);
		String result = "Service Deleted : " + serviceId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}

	@Override
	public List<Service> getServicesBySearchCriteria(String name, String status, 
												  String createrEmail, String ownerId) {
		List<Service> services = sdm.getServicesBySearchCriteria(name, status, createrEmail, ownerId);
		return services;
	}
	@Override
	public List<Bid> getBidsByServiceId(String serviceId) {
		List<Bid> bids = sdm.retrieveOffersByServiceId(serviceId);
        return bids;
	}
	@Override
	public Response createBid(String serviceId, Bid bid) {
		bid.setServiceId(serviceId);
        String bidId = sdm.createBid(bid);
        String result = "Bid created : " + bidId + "-" + bid;
        System.out.println("++++++++++++++++" + result + "++++++++++++++++");
        return Response.status(201).entity(result).build();
	}




}
