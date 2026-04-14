
package com.sap.scimono.api;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SecurityHeadersFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    responseContext.getHeaders().putSingle("X-Content-Type-Options", "nosniff");
    responseContext.getHeaders().putSingle("X-Frame-Options", "DENY");
    responseContext.getHeaders().putSingle("Cache-Control", "no-store");
  }
}
