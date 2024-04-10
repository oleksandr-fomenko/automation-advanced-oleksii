package org.training.ui.pages.launches.components;

import lombok.Getter;

@Getter
public class Launch {
    private final String selector = "[class*='gridRow__grid-row-wrapper']";
    private final String productBugsReportLinkSelector = "a[href*='Dpb']";
    private final String automationBugsReportLinkSelector = "a[href*='Dab']";
    private final String systemIssuesReportLinkSelector = "a[href*='Dsi']";
    private final String toInvestigateReportLinkSelector = "a[href*='Dti']";
}