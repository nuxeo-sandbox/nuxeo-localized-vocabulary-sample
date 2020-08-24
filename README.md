## Description
This package contains a sample vcabulary with localized label columns. This makes it possible for end users to manage the vocabulary entries directly in the application as opposed to  opposed to using server or UI translation files 

## Important Note

**These features are not part of the Nuxeo Production platform.**

These solutions are provided for inspiration and we encourage customers to use them as code samples and learning resources.

This is a moving project (no API maintenance, no deprecation process, etc.) If any of these solutions are found to be useful for the Nuxeo Platform in general, they will be integrated directly into platform, not maintained here.

## How to build
Building requires the following software:
- git
- maven

```
git clone https://github.com/nuxeo-sandbox/nuxeo-localized-vocabulary-sample
cd nuxeo-localized-vocabulary-sample
mvn clean install
```

## Deploying
* Install the marketplace package from the admin center or using nuxeoctl

## Test
- Log in webui as an administrator or poweruser
- Go to the Administration menu / Vocabularies
- Select the sample_l10n_vocabulary
- Add and entry

## How it works
This sample contains the following elements:
- a [schema xsd](https://github.com/nuxeo-sandbox/nuxeo-localized-vocabulary-sample/blob/master/nuxeo-localized-vocabulary-sample-core/src/main/resources/data/schemas/extendedl10nxvocabulary.xsd) with one column for each label language 
- a [schema contribution](https://github.com/nuxeo-sandbox/nuxeo-localized-vocabulary-sample/blob/master/nuxeo-localized-vocabulary-sample-core/src/main/resources/OSGI-INF/schema-contrib.xml)
- a [vocabulary contribution](https://github.com/nuxeo-sandbox/nuxeo-localized-vocabulary-sample/blob/master/nuxeo-localized-vocabulary-sample-core/src/main/resources/OSGI-INF/directory-contrib.xml) which uses the previously defined schema
- a [webui layout](https://github.com/nuxeo-sandbox/nuxeo-localized-vocabulary-sample/blob/master/nuxeo-localized-vocabulary-sample-core/src/main/resources/nuxeo.war/ui/directory/extendedl10nxvocabulary/nuxeo-extendedl10nxvocabulary-edit-layout.html) to add/edit entries in the nuxeo application  

The same schema can be reused for multiple vocabularies.

When using a localized vocabulary with a nuxeo-directory-suggestion widget in webui, don't forget to set the dbl10n attribute to true.

```
<nuxeo-directory-suggestion directory-name="sample_l10n_vocabulary" dbl10n="true"></nuxeo-directory-suggestion>
```

## Known limitations
This plugin is a work in progress.

## About Nuxeo
Nuxeo dramatically improves how content-based applications are built, managed and deployed, making customers more agile, innovative and successful. Nuxeo provides a next generation, enterprise ready platform for building traditional and cutting-edge content oriented applications. Combining a powerful application development environment with SaaS-based tools and a modular architecture, the Nuxeo Platform and Products provide clear business value to some of the most recognizable brands. More information is available at [www.nuxeo.com](http://www.nuxeo.com).
