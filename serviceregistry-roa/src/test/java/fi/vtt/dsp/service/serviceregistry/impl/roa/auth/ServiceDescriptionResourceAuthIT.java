package fi.vtt.dsp.service.serviceregistry.impl.roa.auth;


import javax.ws.rs.core.Response;


import fi.vtt.dsp.service.serviceregistry.auth.token.AgentRole;
import fi.vtt.dsp.service.serviceregistry.auth.token.AgentType;
import fi.vtt.dsp.service.serviceregistry.common.ServiceRegistryEntry;
import fi.vtt.dsp.service.serviceregistry.common.description.ServiceDescription;
import fi.vtt.dsp.service.serviceregistry.impl.roa.StaticResourceAuthIT;

public class ServiceDescriptionResourceAuthIT
		extends
			StaticResourceAuthIT<ServiceDescription> {

	public ServiceDescriptionResourceAuthIT() {

		// set expected responses
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);

		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
	}

	private String getResourcePath(ServiceRegistryEntry service) {
		return String.format(PATH_SERVICE, service.getServiceId())
				+ "/servicedescription";
	}

	@Override
	protected ServiceDescription getTestResource() {
		return serviceAgent.getServiceDescription();
	}

	@Override
	protected ServiceDescription getOtherTestResource() {
		return otherService.getServiceDescription();
	}

	@Override
	protected String getTestResourcePath() {
		return getResourcePath(serviceAgent);
	}

	@Override
	protected String getOtherTestResourcePath() {
		return getResourcePath(otherService);
	}
}
