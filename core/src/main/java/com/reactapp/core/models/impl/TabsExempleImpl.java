/*
 * ***********************************************************************
 * React App CONFIDENTIAL
 * ___________________
 *
 * Copyright 2022 React App.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of React App and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to React App
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from React App.
 * ***********************************************************************
 */

package com.reactapp.core.models.impl;

import java.util.Collections;
import java.util.List;
import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.reactapp.core.models.TabsExemple;
import com.reactapp.core.models.exempleTwoModel;
import com.reactapp.core.models.multifieldOneModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    TabsExemple.class,
    ComponentExporter.class
}, resourceType = "reactapp/components/tabs-exemple")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TabsExempleImpl
    implements TabsExemple
{

    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    private List<multifieldOneModel> exempleOne;
    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    private List<exempleTwoModel> exempleTwo;
    @SlingObject
    private Resource resource;

    @Override
    public List<multifieldOneModel> getExempleOne() {
        return exempleOne != null ? Collections.unmodifiableList(exempleOne) : null;
    }

    @Override
    public List<exempleTwoModel> getExempleTwo() {
        return exempleTwo != null ? Collections.unmodifiableList(exempleTwo) : null;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
