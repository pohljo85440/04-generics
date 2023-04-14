package ohm.softa.a04;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {

	void setAtIndex(int index, T item);
	T getAtIndex(int index);


	/**
	 * Add a given object to the back of the list.
	 */
	void add(T item);

	void addDefault(Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 *
	 * @return a new, filtered list
	 */
	default SimpleList<T> filter(SimpleFilter<T> filter) {
		SimpleList<T> result = new SimpleListImpl<>();
		for(T o : this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}

	 default <R> SimpleList<R> map(Function<T, R> transform) {
		SimpleList<R> result = new SimpleListImpl<>();
		 for (T element : this) {
			 result.add(transform.apply(element));
		 }
		return result;
	}
}
