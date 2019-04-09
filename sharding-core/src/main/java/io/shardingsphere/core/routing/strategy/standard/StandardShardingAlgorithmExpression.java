package io.shardingsphere.core.routing.strategy.standard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StandardShardingAlgorithmExpression {

//	private static final String FIELD_ALGORITHM_EXPRESSION = "algorithmExpression";
	private static final String GETTER_ALGORITHM_EXPRESSION = "getAlgorithmExpression";
	private static final String SETTER_ALGORITHM_EXPRESSION = "setAlgorithmExpression";

	/**
	 * 获取分片算法表达式
	 * 
	 * @param shardingAlgorithmObj the sharding algorithm object which extends ShardingAlgorithm
	 */
	public static String getAlgorithmExpression(Object shardingAlgorithmObj) {
		try {
			if (null != shardingAlgorithmObj) {
//				Field fieldAlgorithmExpression = shardingAlgorithmObj.getClass().getDeclaredField(FIELD_ALGORITHM_EXPRESSION);
//				fieldAlgorithmExpression.setAccessible(true);
//				String ret = (String) fieldAlgorithmExpression.get(shardingAlgorithmObj);
//				return ret;
				Method getter = shardingAlgorithmObj.getClass().getMethod(GETTER_ALGORITHM_EXPRESSION);
				Object ret = getter.invoke(shardingAlgorithmObj);
				return (String) ret;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置分片算法表达式
	 * 
	 * @param shardingAlgorithmObj the sharding algorithm object which extends ShardingAlgorithm
	 * @param algorithmExpression  the algorithm expression
	 */
	public static void putAlgorithmExpression(Object shardingAlgorithmObj, String algorithmExpression) {
		try {
			if (null != shardingAlgorithmObj && null != algorithmExpression) {
//				Field fieldAlgorithmExpression = shardingAlgorithmObj.getClass().getDeclaredField(FIELD_ALGORITHM_EXPRESSION);
//				fieldAlgorithmExpression.setAccessible(true);
//				fieldAlgorithmExpression.set(shardingAlgorithmObj, algorithmExpression);
				Method setter = shardingAlgorithmObj.getClass().getMethod(SETTER_ALGORITHM_EXPRESSION, String.class);
				setter.invoke(shardingAlgorithmObj, algorithmExpression);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
