package org.camunda.bpm.integrationtest.util;

import org.jboss.shrinkwrap.api.spec.WebArchive;


/**
 *
 * @author christian.lipphardt
 */
public class TestContainer {

  public static void addContainerSpecificResources(WebArchive webArchive) {
    addContainerSpecificResourcesWithoutWeld(webArchive);
  }

  public static void addContainerSpecificResourcesWithoutWeld(WebArchive webArchive) {
    webArchive.addAsLibraries(DeploymentHelper.getEjbClient());
  }

  public static void addContainerSpecificResourcesForNonPa(WebArchive webArchive) {
    addContainerSpecificResourcesForNonPaWithoutWeld(webArchive);
  }

  public static void addContainerSpecificResourcesForNonPaWithoutWeld(WebArchive webArchive) {
    webArchive.addAsManifestResource("jboss-deployment-structure.xml");
  }

  public static void addContainerSpecificProcessEngineConfigurationClass(WebArchive deployment) {
    // nothing to do
  }

  public static void addSpinJacksonJsonDataFormat(WebArchive webArchive) {
    webArchive.addAsManifestResource("jboss-deployment-structure-spin-json.xml", "jboss-deployment-structure.xml");
  }

  public static void addJodaTimeJacksonModule(WebArchive webArchive) {
    webArchive.addAsLibraries(DeploymentHelper.getJodaTimeModuleForServer("jboss"));
  }

  public static void addCommonLoggingDependency(WebArchive webArchive) {
    webArchive.addAsManifestResource("jboss-deployment-structure-with-commons-logging.xml", "jboss-deployment-structure.xml");
  }
}