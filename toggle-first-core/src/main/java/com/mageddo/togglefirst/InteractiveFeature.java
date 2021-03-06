package com.mageddo.togglefirst;

/**
 * A feature which have the power check itself state, it can communicate with the
 * feature manager and check if it is active, retrieve feature metadata
 */
public interface InteractiveFeature extends Feature {

	FeatureManager manager();

	default Integer asInteger(){
		return metadata().asInteger(FeatureKeys.VALUE);
	}

	default Integer asInteger(Integer defaultValue){
		return metadata().asInteger(FeatureKeys.VALUE, defaultValue);
	}

	default Integer asInteger(String user){
		return asInteger(user, null);
	}

	default Integer asInteger(String user, Integer defaultValue){
		return metadata(user).asInteger(FeatureKeys.VALUE, defaultValue);
	}

	default Long asLong(){
		return metadata().asLong(FeatureKeys.VALUE);
	}

	default Long asLong(Long defaultValue){
		return metadata().asLong(FeatureKeys.VALUE, defaultValue);
	}

	default Long asLong(String user){
		return asLong(user, null);
	}

	default Long asLong(String user, Long defaultValue){
		return metadata(user).asLong(FeatureKeys.VALUE, defaultValue);
	}

	default String value(){
		return metadata().value();
	}

	default String value(String user){
		return metadata(user).value();
	}

	default String value(String user, String defaultValue){
		return metadata(user).value(defaultValue);
	}

	default boolean isActive(){
		return isActive(null);
	}

	default boolean isActive(String user){
		return manager().isActive(this, user);
	}

	default Boolean asBoolean(){
		return metadata().asBoolean(FeatureKeys.VALUE);
	}

	default Boolean asBoolean(Boolean defaultValue){
		return metadata().asBoolean(FeatureKeys.VALUE, defaultValue);
	}

	default Boolean asBoolean(String user){
		return metadata(user).asBoolean(FeatureKeys.VALUE, null);
	}

	default Boolean asBoolean(String user, Boolean defaultValue){
		return metadata(user).asBoolean(FeatureKeys.VALUE, defaultValue);
	}

	default FeatureMetadata metadata(){
		return metadata(null);
	}

	default FeatureMetadata metadata(String user){
		return manager().metadata(this, user);
	}

}
