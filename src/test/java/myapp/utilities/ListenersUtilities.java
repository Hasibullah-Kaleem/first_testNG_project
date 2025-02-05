package myapp.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtilities implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        //BeforeSuite Annatotaion, like beforeAll

        System.out.println("onStart : executes only BEFORE ALL test " + context.getName());

    }


    @Override
    public void onFinish(ITestContext context) {

        //AfterAll anatotation

        System.out.println("onFinis : executes only once AFTER ALL test" + context.getName());


    }

    @Override
    public void onTestStart(ITestResult result) {

        //BeforeEach anatation

        System.out.println("onTestStart : executes only before each test " + result.getName());

    }


    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("OnTestSkipped : executes only when the test is skipped " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("OnTestFailure : executes only after each failed test " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("OnTestSuccess : executes only after each passing test " + result.getName());

    }


    // Rerun failed test cases automatically one more time
    private int retryCount = 0;
    private static final int maxRetryCount =1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (retryCount<maxRetryCount){

            retryCount++;
            return true;
        }
        return false;
    }


    //Annatotation method is added in the class level
    //this makes the failed test cases it will make automatically rerun
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtilities.class);
    }


    //    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }


//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }

}