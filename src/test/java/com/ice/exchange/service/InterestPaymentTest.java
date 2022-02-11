/*
 * No Copyright intended or License applies just for templating.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.ice.exchange.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ice.exchange.model.Payment;

/**
 * JUnit Test class for InterestPayment
 * @author PM
 *
 */
public class InterestPaymentTest {

	Logger logger = Logger.getLogger(InterestPaymentTest.class.getName());
	
	/** The class under tests. */
	InterestPayment interestPayment;
	
	long dayNumber = 10l; 
	BigDecimal rate = BigDecimal.valueOf(25);

	/**
	 * Runs before the tests.
	 */
	@Before
	public void setUp() throws Exception {
		interestPayment = new InterestPayment(new Payment(dayNumber, rate));
	}
	
	
	/**
	 * Runs after the tests.
	 */
	@After
	public void tearDown() throws Exception {
		interestPayment = null;
	}

	/**
	 * Test method for
	 * InterestPayment.updatePayment(Payment(java.lang.Long,
	 * java.math.BigDecimal))
	 * 
	 */
	@Test
	public void updatePaymentWithDaysDifferenceGreaterThanFiveAndValidRateTest() throws Exception {
		logger.info("Begin: Testing InterestPayment.updatePayment method.");

		long dayNum1 = 17l;
		BigDecimal rate1 = BigDecimal.valueOf(25);
		Assert.assertEquals(false, interestPayment.updatePayment(new Payment(dayNum1, rate1)));
		
	}
	
	/**
	 * Test method for
	 * InterestPayment.updatePayment(Payment(java.lang.Long,
	 * java.math.BigDecimal))
	 * 
	 */
	@Test
	public void updatePaymentWithDaysDifferenceLessThanFiveAndValidRateTest() throws Exception {
		logger.info("Begin: Testing InterestPayment.updatePayment method.");

		long dayNum1 = 12l;
		BigDecimal rate1 = BigDecimal.valueOf(25);
		Assert.assertEquals(true, interestPayment.updatePayment(new Payment(dayNum1, rate1)));
		
	}
	
	/**
	 * Test method for
	 * InterestPayment.updatePayment(Payment(java.lang.Long,
	 * java.math.BigDecimal))
	 * 
	 * This is one of the test case that is failing because of the issue in given sample code
	 */
	@Test
	public void updatePaymentWithDaysGreaterThanLongRangeAndValidRateTest() throws Exception {
		logger.info("Begin: Testing InterestPayment.updatePayment method.");

		long dayNum1 = Long.MAX_VALUE;
		BigDecimal rate1 = BigDecimal.valueOf(25);
		Assert.assertEquals(false, new InterestPayment(new Payment(-1, rate1)).updatePayment(new Payment(dayNum1, rate1)));
		
	}
	
	/**
	 * Test method for
	 * InterestPayment.updatePayment(Payment(java.lang.Long,
	 * java.math.BigDecimal))
	 * 
	 * This is one of the test case that is failing because of the issue in given sample code
	 */
	@Test
	public void updatePaymentWithDaysLessThanLongRangeAndValidRateTest() throws Exception {
		logger.info("Begin: Testing InterestPayment.updatePayment method.");

		long dayNum1 = Long.MIN_VALUE ;
		BigDecimal rate1 = BigDecimal.valueOf(25);
		Assert.assertEquals(true, new InterestPayment(new Payment(1, rate1)).updatePayment(new Payment(dayNum1, rate1)));
		
	}

}
