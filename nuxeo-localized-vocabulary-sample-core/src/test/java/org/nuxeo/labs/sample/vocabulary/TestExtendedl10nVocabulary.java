/*
 * (C) Copyright 2020 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Michael Vachette
 */

package org.nuxeo.labs.sample.vocabulary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.Granularity;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.directory.Directory;
import org.nuxeo.ecm.directory.Session;
import org.nuxeo.ecm.directory.api.DirectoryService;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RunWith(FeaturesRunner.class)
@Features(PlatformFeature.class)
@RepositoryConfig(init = DefaultRepositoryInit.class, cleanup = Granularity.METHOD)
@Deploy("nuxeo-localized-vocabulary-sample-core")
public class TestExtendedl10nVocabulary {

    @Inject
    DirectoryService directoryService;

    @Test
    public void testAddEntryToVocabulary() {
        Directory directory = directoryService.getDirectory("sample_l10_vocabulary");
        Assert.assertNotNull(directory);

        Session directorySession = directory.getSession();

        Map<String, Object> entry = new HashMap<>();
        entry.put("id", "japan");
        entry.put("label_en","Japan");
        entry.put("label_fr","Japon");
        entry.put("label_pt","Japão");
        entry.put("label_ja","日本");
        entry.put("obsolete", 0);
        entry.put("ordering", 0);
        directorySession.createEntry(entry);

        DocumentModel savedEntry = directorySession.getEntry("japan");
        Assert.assertNotNull(savedEntry);

        String schemaName = directory.getSchema();
        Assert.assertEquals("japan",savedEntry.getId());
        Assert.assertEquals("Japan",savedEntry.getPropertyValue(schemaName+":label_en"));
        Assert.assertEquals("Japon",savedEntry.getPropertyValue(schemaName+":label_fr"));
        Assert.assertEquals("Japão",savedEntry.getPropertyValue(schemaName+":label_pt"));
        Assert.assertEquals("日本",savedEntry.getPropertyValue(schemaName+":label_ja"));
        Assert.assertEquals(0l,savedEntry.getPropertyValue(schemaName+":obsolete"));
        Assert.assertEquals(0l,savedEntry.getPropertyValue(schemaName+":ordering"));
    }
}
