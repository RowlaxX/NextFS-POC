package nextfs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import deduper.Shape.States;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

public class Space {
	private final Shape shape;
	private final List<Space> childs;
	private final Space parent;

	private int size = 0;

	/*
	 * Get Space related methods
	 */
	private Space $getSpace(Point point) {
		List<Space> parents = List.of(this);
		List<Space> childs;

		while (true) {
			childs = $getPotentialChildSpaces(parents, point);

			if (childs.isEmpty())
				return $getBestSpace(parents, point);

			parents = childs;
		}
	}

	private List<Space> $getPotentialChildSpaces(Collection<Space> spaces, Point point) {
		var result = new LinkedList<Space>();
		AtomicReference<Space> perfect = new AtomicReference<Space>();
		
		spaces.parallelStream().forEach(space -> {
			loop: for (Space child : space.childs)
				perfect.get
				if (perfect != null)
					break;
				else
					switch (child.shape.getState(point)) {
						case ORIGIN -> {
							perfect = child;
							break loop;
						}
						case INSIDE -> {
							synchronized (result) {
								result.add(child);
							}
						}
						default -> {}
					}
		});

		return result;
	}

	private Space $getBestSpace(List<Space> parents, Point point) {
		return parents.parallelStream().reduce(
				(s1, s2) -> s1.shape.getDistanceWithOrigin(point) < s2.shape.getDistanceWithOrigin(point) ? s1 : s2)
				.get();
	}

	@Override
	public void add(Point point) {
		if (!shape.contains(point))
			throw new IllegalArgumentException("This shape don't contains this point");
		$add(point);
	}

	private void $add(Point point) {
		Space space = $getSpace(point);
		if (space.shape.getDistanceWithOrigin(point))
	}

	@Override
	public void contains(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findNearests(Point reference, int n, int maxDistance) {
		// TODO Auto-generated method stub

	}

}
