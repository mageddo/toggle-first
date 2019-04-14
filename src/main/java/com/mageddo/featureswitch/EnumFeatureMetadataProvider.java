package com.mageddo.featureswitch;

import com.mageddo.commons.AnnotationUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Activating this Metadata provider you will be able to annotate your enum feature with default values and default status
 *
 * @see FeatureManager
 */
public class EnumFeatureMetadataProvider implements FeatureMetadataProvider {
	@Override
	public FeatureMetadata getMetadata(Feature feature) {
		final FeatureDefaults an = AnnotationUtils.getAnnotation(feature, FeatureDefaults.class);
		final Map<String, String> m = new HashMap<>();
		if(an == null){
			m.put(FeatureKeys.STATUS, String.valueOf(Status.INACTIVE.getCode()));
			m.put(FeatureKeys.VALUE, "");
		} else {
			m.put(FeatureKeys.STATUS, String.valueOf(an.status().getCode()));
			m.put(FeatureKeys.VALUE, an.value());
		}
		return new DefaultFeatureMetadata(feature, m);
	}
}
