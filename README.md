![](https://i.imgur.com/0hG2AWi.png)

[source](https://drive.google.com/file/d/1ri4A7a6Ze788m9iErIf1gYs3fWc7lPDz/view)

### Using With Spring

Register feature manager for database persistence

```java
@Bean
public FeatureManager featureManager(DataSource dataSource){
	return new DefaultFeatureManager()
		.featureMetadataProvider(new EnumFeatureMetadataProvider())
		.featureRepository(new JDBCFeatureRepository(dataSource))
	;
}
```

Create your Feature enum

```java
public enum Parameter implements InteractiveFeature {

	@FeatureDefaults(status = Status.ACTIVE, value = "Congrats!")
	FREE_COINS

	;

	@Override
	public FeatureManager manager() {
		return FeatureContext.getFeatureManager();
	}
}
```

Using

```java
Parameter.FREE_COINS.isActive();
```

### Registering JMX

```java
FeatureSwitchJMX.register();
```
