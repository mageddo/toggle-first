package com.mageddo.togglefirst;

import com.mageddo.togglefirst.activation.ActivationStrategy;
import com.mageddo.togglefirst.repository.FeatureRepository;

import java.util.Map;
import java.util.Set;

/**
 * Make a bridge between who ask for the feature metadata, the {@link FeatureRepository} and the activation strategies.
 *
 * Use this class to check if feature is active, to retrieve metadata, etc
 *
 * @see DefaultFeatureManager
 */
public interface FeatureManager {

	Set<ActivationStrategy> activationStrategies();

	/**
	 * Retrieve the current repository for the project
	 */
	FeatureRepository repository();

	FeatureMetadataProvider metadataProvider();

	/**
	 * Just activate feature, should keep original feature parameters
	 * @see FeatureKeys
	 */
	void activate(Feature feature);

	/**
	 * Activate feature and set value parameter, keep original parameters untouched
	 * @see FeatureKeys
	 */
	void activate(Feature feature, String value);

	/**
	 * Set feature as restricted then activate for user, keep original parameters untouched
	 * @see FeatureKeys
	 */
	void userActivate(Feature feature, String user);

	/**
	 * Set feature as restricted then activate for user with specified value, keep original parameters untouched
	 * @see FeatureKeys
	 */
	void userActivate(Feature feature, String user, String value);

	/**
	 * Deactivate feature, should keep original feature parameters
	 * @see FeatureKeys
	 */
	void deactivate(Feature feature);

	/**
	 * Deactivate feature to user, should keep original feature parameters
	 * @see FeatureKeys
	 */
	void userDeactivate(Feature feature, String user);

	void updateMetadata(Feature feature, Map<String, String> parameters);

	/**
	 * Merge especified parameters to the already existing
	 * @param feature
	 * @param user
	 * @param parameters
	 */
	void updateMetadata(Feature feature, String user, Map<String, String> parameters);

	/**
	 * Retrieve feature metadata from Repository or the default metadata if
	 */
	FeatureMetadata metadata(Feature feature);

	/**
	 * Retrieve feature metadata for the specified user from Repository or the default metadata.
	 * <ol>
	 * <li>If Feature is active must return metadata from the feature not the user feature</li>
	 * <li>If Feature is restricted must return metadata from the user feature even if it have not any</li>
	 * <li>If Feature is inactive must return null</li>
	 * <li>If there is no default or Repository feature data then must return null</li>
	 * </ol>
	 */
	FeatureMetadata metadata(Feature feature, String user);

	/**
	 * Check if feature is active
	 */
	boolean isActive(Feature feature);

	/**
	 *
	 * Check if feature is active for user, if no user is passed then will check if the feature itself is active
	 */
	boolean isActive(Feature feature, String user);

	String value(Feature feature);

	String value(Feature feature, String user);

}
