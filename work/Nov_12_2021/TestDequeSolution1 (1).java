package datastructure.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.IntFunction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
// import org.junit.Test;// do not use JUnit 4

/**
 * Lab 2 solution
 * 
 * @author Shariar (Shawn) Emami
 * @version Nov 11, 2020
 */
@DisplayName( "Basic LinkedList Test")
@TestMethodOrder( OrderAnnotation.class)
public class TestDequeSolution {

	private Random rand = new Random( 1);
	private Deque< Integer> list;

	@BeforeEach
	void setup() {
		list = new LinkedListDeque<>();
	}

	@AfterEach
	void tearDown() {
		
		list.clear();
	}

	< T> void loadSomeData( Collection< T> array, final int offset, final int COUNT, IntFunction< T> sup) {
		for ( int i = offset; i < offset + COUNT; i++)
			array.add( sup.apply( i));
	}

	< T> void loadSomeData( Collection< T> array, final int COUNT, IntFunction< T> sup) {
		loadSomeData( array, 0, COUNT, sup);
	}

	@Nested
	@DisplayName( "Constructor Test")
	@TestMethodOrder( OrderAnnotation.class)
	class ConstructorTest {

		@Test
		@Order( 1)
		@DisplayName( "Constructor no-arg")
		final void testLinkedList() {
			assertNotNull( list);
			assertEquals( 0, list.size());
			assertTrue( list.isEmpty());
			assertNull( list.peekFirst());
			assertNull( list.peekLast());
			assertNull( list.pollFirst());
			assertNull( list.pollLast());
		}
	}

	@Nested
	@DisplayName( "offerFirst Test")
	@TestMethodOrder( OrderAnnotation.class)
	class OfferFirstTest {

		@Test
		@Order( 1)
		@DisplayName( "one element, size check")
		final void testOfferToEmptySize() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			assertEquals( 1, list.size());
			assertFalse( list.isEmpty());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element check")
		final void testOfferToEmptyElement() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			assertEquals( 1, list.pollFirst());
		}

		@Test
		@DisplayName( "Add null to an empty list twice")
		@Order( 3)
		void testOfferingNullToList() {
			Integer test = null;
			assertTrue( list.isEmpty());
			assertTrue( list.offerFirst( test));
			assertNull( list.peekFirst());

			assertTrue( list.offerFirst( test));
			assertNull( list.peekFirst());
			assertNull( list.peekLast());

			assertEquals( 2, list.size());
		}

		@Test
		@DisplayName( "Add to a none empty list once")
		@Order( 4)
		void testOfferingToNoneEmptyList() {
			int test1 = 1;
			assertTrue( list.isEmpty());
			assertTrue( list.offerFirst( test1));
			assertEquals( test1, list.peekFirst());

			int test2 = 2;
			assertTrue( list.offerFirst( test2));
			assertEquals( test2, list.peekFirst());
			assertEquals( test1, list.peekLast());

			assertEquals( 2, list.size());
		}

		@Test
		@Order( 5)
		@DisplayName( "many, size check")
		final void testOfferManySizeChange() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				int num = rand.nextInt( Integer.MAX_VALUE);
				list.offerFirst( num);
				assertEquals( i + 1, list.size(), "On index=\"" + i + "\"");
			}
		}

		@Test
		@Order( 6)
		@DisplayName( "many, element check")
		final void testOfferManyElementChange() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				int num = rand.nextInt( Integer.MAX_VALUE);
				list.offerFirst( num);
				assertEquals( num, list.peekFirst(), "On index=\"" + i + "\"");
			}
		}
	}

	@Nested
	@DisplayName( "offerLast Test")
	@TestMethodOrder( OrderAnnotation.class)
	class OfferLastTest {

		@Test
		@Order( 1)
		@DisplayName( "one element, size check")
		final void testOfferToEmptySize() {
			assertTrue( list.isEmpty());
			list.offerLast( 1);
			assertEquals( 1, list.size());
			assertFalse( list.isEmpty());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element check")
		final void testOfferToEmptyElement() {
			assertTrue( list.isEmpty());
			list.offerLast( 1);
			assertEquals( 1, list.pollFirst());
		}

		@Test
		@DisplayName( "Add null to an empty list twice")
		@Order( 3)
		void testOfferingNullToList() {
			Integer test = null;
			assertTrue( list.isEmpty());
			assertTrue( list.offerLast( test));
			assertNull( list.peekLast());

			assertTrue( list.offerLast( test));
			assertNull( list.peekLast());
			assertNull( list.peekLast());

			assertEquals( 2, list.size());
		}

		@Test
		@DisplayName( "Add to a none mepty list once")
		@Order( 4)
		void testOfferingToNoneEmptyList() {
			int test1 = 1;
			assertTrue( list.isEmpty());
			assertTrue( list.offerLast( test1));
			assertEquals( test1, list.peekLast());

			int test2 = 2;
			assertTrue( list.offerLast( test2));
			assertEquals( test1, list.peekFirst());
			assertEquals( test2, list.peekLast());

			assertEquals( 2, list.size());
		}

		@Test
		@Order( 5)
		@DisplayName( "many, size check")
		final void testOfferManySizeChange() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				int num = rand.nextInt( Integer.MAX_VALUE);
				list.offerLast( num);
				assertEquals( i + 1, list.size(), "On index=\"" + i + "\"");
			}
		}

		@Test
		@Order( 6)
		@DisplayName( "many, element check")
		final void testOfferManyElementChange() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				int num = rand.nextInt( Integer.MAX_VALUE);
				list.offerLast( num);
				assertEquals( num, list.peekLast(), "On index=\"" + i + "\"");
			}
		}
	}

	@Nested
	@DisplayName( "peekFirst Test")
	@TestMethodOrder( OrderAnnotation.class)
	class PeekFirstTest {

		@Test
		@Order( 1)
		@DisplayName( "empty")
		final void testPeekFirstOnEmpty() {
			assertTrue( list.isEmpty());
			assertNull( list.peekFirst());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element check")
		final void testGetFirstSizeOne() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			assertEquals( 1, list.peekFirst());
		}

		@Test
		@Order( 3)
		@DisplayName( "two elements, element check")
		final void testPeekFirstSizeTwo() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerFirst( 2);
			assertEquals( 2, list.peekFirst());
		}

		@Test
		@Order( 4)
		@DisplayName( "three elements, element check")
		final void testPeekFirstSizeThree() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerFirst( 2);
			list.offerFirst( 3);
			assertEquals( 3, list.peekFirst());
		}

		@Test
		@Order( 5)
		@DisplayName( "many")
		final void testGetFirstMany() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				list.offerFirst( i);
				assertEquals( i, list.peekFirst());
			}
		}
	}

	@Nested
	@DisplayName( "peekLast Test")
	@TestMethodOrder( OrderAnnotation.class)
	class PeekLastTest {

		@Test
		@Order( 1)
		@DisplayName( "empty")
		final void testPeekLastOnEmpty() {
			assertTrue( list.isEmpty());
			assertNull( list.peekLast());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element check")
		final void testGetLastSizeOne() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			assertEquals( 1, list.peekLast());
		}

		@Test
		@Order( 3)
		@DisplayName( "two elements, element check")
		final void testPeekLastSizeTwo() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerFirst( 2);
			assertEquals( 1, list.peekLast());
		}

		@Test
		@Order( 4)
		@DisplayName( "three elements, element check")
		final void testPeekLastSizeThree() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerFirst( 2);
			list.offerFirst( 3);
			assertEquals( 1, list.peekLast());
		}

		@Test
		@Order( 5)
		@DisplayName( "many")
		final void testGetLastMany() {
			assertTrue( list.isEmpty());
			for ( int i = 0; i < 100; i++) {
				list.offerLast( i);
				assertEquals( i, list.peekLast());
			}
		}
	}

	@Nested
	@DisplayName( "Size, Clear, and isEmpty Test")
	@TestMethodOrder( OrderAnnotation.class)
	class SizeTest {

		@Test
		@Order( 1)
		@DisplayName( "size test with offer")
		final void testSizeWithOffer() {
			assertEquals( 0, list.size());
			loadSomeData( list, 9, i -> i);
			assertEquals( 9, list.size());

			list.offerLast( 9);
			assertEquals( 10, list.size());
			loadSomeData( list, 10, 5, i -> i);
			assertEquals( 15, list.size());

			list.offerFirst( 15);
			assertEquals( 16, list.size());
			loadSomeData( list, 16, 4, i -> i);
			assertEquals( 20, list.size());
		}

		@Test
		@Order( 2)
		@DisplayName( "size test with Poll")
		final void testSizeWithPoll() {
			assertEquals( 0, list.size());
			loadSomeData( list, 9, i -> i);
			assertEquals( 9, list.size());

			list.pollFirst();
			assertEquals( 8, list.size());
			loadSomeData( list, 8, 5, i -> i);
			assertEquals( 13, list.size());

			list.pollLast();
			assertEquals( 12, list.size());
			loadSomeData( list, 12, 4, i -> i);
			assertEquals( 16, list.size());
		}

		@Test
		@Order( 3)
		@DisplayName( "isEmpty tes with offer")
		final void testIsEmptyWithOffer() {
			assertTrue( list.isEmpty());
			loadSomeData( list, 3, i -> i);
			assertFalse( list.isEmpty());

			list.offerLast( 9);
			assertFalse( list.isEmpty());

			list.offerFirst( 10);
			assertFalse( list.isEmpty());
		}

		@Test
		@Order( 4)
		@DisplayName( "isEmpty test with Poll")
		final void testIsEmptyWithPoll() {
			assertTrue( list.isEmpty());
			loadSomeData( list, 3, i -> i);
			assertFalse( list.isEmpty());

			list.pollFirst();
			assertFalse( list.isEmpty());

			list.pollLast();
			assertFalse( list.isEmpty());

			list.pollLast();
			assertTrue( list.isEmpty());
		}

		@Test
		@Order( 5)
		@DisplayName( "test clear on populated test")
		final void testOnPopulatedList() {
			assertTrue( list.isEmpty());
			assertEquals( 0, list.size());
			list.clear();
			assertTrue( list.isEmpty());
			assertEquals( 0, list.size());

			loadSomeData( list, 9, i -> i);
			assertEquals( 9, list.size());
			assertFalse( list.isEmpty());

			list.clear();
			assertTrue( list.isEmpty());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 6)
		@DisplayName( "test clear on empty list")
		final void testOnEmptyList() {
			assertTrue( list.isEmpty());
			assertEquals( 0, list.size());
			list.clear();
			assertTrue( list.isEmpty());
			assertEquals( 0, list.size());
		}

//		@Test
//		@Order( 7)
//		@DisplayName( "test contains on empty list")
//		final void testContainsEmpty() {
//			assertTrue( list.isEmpty());
//			assertFalse( list.contains( null));
//			assertFalse( list.contains( 1));
//		}
//
//		@Test
//		@Order( 8)
//		@DisplayName( "test contains on populated list")
//		final void testContainsPopulated() {
//			assertTrue( list.isEmpty());
//			assertFalse( list.contains( null));
//			assertFalse( list.contains( 1));
//			assertFalse( list.contains( 2));
//			assertFalse( list.contains( 3));
//			assertFalse( list.contains( 4));
//			for ( int i = 0; i < 100; i++) {
//				list.offerFirst( i);
//			}
//			for ( int i = 0; i < 100; i++) {
//				assertTrue( list.contains( i));
//			}
//		}
//	}

	@Nested
	@DisplayName( "pollFirst Test")
	@TestMethodOrder( OrderAnnotation.class)
	class PollFirstTest {

		@Test
		@Order( 1)
		@DisplayName( "empty")
		final void testPollFirstEmpty() {
			assertTrue( list.isEmpty());
			assertNull( list.pollFirst());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element and size check")
		final void testPollFirstSizeOne() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			assertEquals( 1, list.pollFirst());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 3)
		@DisplayName( "two elements, element and size check")
		final void testPollFirstSizeTwo() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerLast( 2);
			assertEquals( 1, list.pollFirst());
			assertEquals( 1, list.size());
			assertEquals( 2, list.pollFirst());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 4)
		@DisplayName( "three elements, element and size check")
		final void testPollFirstSizeThree() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerLast( 2);
			list.offerFirst( 3);
			assertEquals( 3, list.pollFirst());
			assertEquals( 2, list.size());
			assertEquals( 1, list.pollFirst());
			assertEquals( 1, list.size());
			assertEquals( 2, list.pollFirst());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 5)
		@DisplayName( "many with offerFirst")
		final void testPollFirstManyWithOfferFirst() {
			for ( int i = 0; i < 100; i++) {
				list.offerFirst( i);
			}
			for ( int i = 99; i >= 0; i--) {
				assertEquals( i, list.pollFirst());
			}
		}

		@Test
		@Order( 6)
		@DisplayName( "many with offerLast")
		final void testPollFirstManyWithOfferLast() {
			for ( int i = 0; i < 100; i++) {
				list.offerLast( i);
			}
			for ( int i = 0; i < 100; i++) {
				assertEquals( i, list.pollFirst());
			}
		}
	}

	@Nested
	@DisplayName( "pollLast Test")
	@TestMethodOrder( OrderAnnotation.class)
	class PollLastTest {

		@Test
		@Order( 1)
		@DisplayName( "empty")
		final void testPollLastEmpty() {
			assertTrue( list.isEmpty());
			assertNull( list.pollLast());
		}

		@Test
		@Order( 2)
		@DisplayName( "one element, element and size check")
		final void testPollLastSizeOne() {
			assertTrue( list.isEmpty());
			list.offerLast( 1);
			assertEquals( 1, list.pollLast());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 3)
		@DisplayName( "two elements, element and size check")
		final void testPollLastSizeTwo() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerLast( 2);
			assertEquals( 2, list.pollLast());
			assertEquals( 1, list.size());
			assertEquals( 1, list.pollLast());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 4)
		@DisplayName( "three elements, element and size check")
		final void testPollLastSizeThree() {
			assertTrue( list.isEmpty());
			list.offerFirst( 1);
			list.offerLast( 2);
			list.offerFirst( 3);
			assertEquals( 2, list.pollLast());
			assertEquals( 2, list.size());
			assertEquals( 1, list.pollLast());
			assertEquals( 1, list.size());
			assertEquals( 3, list.pollLast());
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 5)
		@DisplayName( "many with offerLast")
		final void testPollLastManyWithOfferLast() {
			int maxSize = 100;
			for ( int i = 0; i < maxSize; i++) {
				list.offerLast( i);
			}
			assertEquals( maxSize, list.size());
			for ( int i = maxSize - 1; i >= 0; i--) {
				assertEquals( i, list.pollLast());
				assertEquals( --maxSize, list.size());
			}
			assertEquals( 0, list.size());
		}

		@Test
		@Order( 6)
		@DisplayName( "many with offerFirst")
		final void testPollLastManyWithOfferFirst() {
			int maxSize = 100;
			for ( int i = 0; i < maxSize; i++) {
				list.offerFirst( i);
			}
			assertEquals( maxSize, list.size());
			int loopSize = maxSize;
			for ( int i = 0; i < loopSize; i++) {
				assertEquals( i, list.pollLast());
				assertEquals( --maxSize, list.size());
			}
			assertEquals( 0, list.size());
		}
	}
	}
}


		
	

