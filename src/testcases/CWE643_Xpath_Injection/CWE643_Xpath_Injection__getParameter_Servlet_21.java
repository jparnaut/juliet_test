/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__getParameter_Servlet_21.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import javax.servlet.http.*;


import javax.xml.xpath.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Xpath_Injection__getParameter_Servlet_21 extends AbstractTestCaseServlet
{
    /* The variable below is used to drive control flow in the sink function */
    private boolean badPrivate = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        badPrivate = true;
        badSink(data , request, response);
    }

    private void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (badPrivate)
        {
            String xmlFile = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
            }
            else
            {
                /* running on non-Windows */
                xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
            }
            if (data != null)
            {
                /* assume username||password as source */
                String [] tokens = data.split("||");
                if (tokens.length < 2)
                {
                    return;
                }
                String username = tokens[0];
                String password = tokens[1];
                /* build xpath */
                XPath xPath = XPathFactory.newInstance().newXPath();
                InputSource inputXml = new InputSource(xmlFile);
                /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
                 *     The user input should be canonicalized before validation. */
                /* POTENTIAL FLAW: user input is used without validate */
                String query = "//users/user[name/text()='" + username +
                "' and pass/text()='" + password + "']" +
                "/secret/text()";
                String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
            }
        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1Private = false;
    private boolean goodB2G2Private = false;
    private boolean goodG2BPrivate = false;

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
        goodG2B(request, response);
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        goodB2G1Private = false;
        goodB2G1Sink(data , request, response);
    }

    private void goodB2G1Sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodB2G1Private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            String xmlFile = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
            }
            else
            {
                /* running on non-Windows */
                xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
            }

            if (data != null)
            {
                /* assume username||password as source */
                String [] tokens = data.split("||");
                if( tokens.length < 2 )
                {
                    return;
                }
                /* FIX: validate input using StringEscapeUtils */
                String username = StringEscapeUtils.escapeXml(tokens[0]);
                String password = StringEscapeUtils.escapeXml(tokens[1]);
                /* build xpath */
                XPath xPath = XPathFactory.newInstance().newXPath();
                InputSource inputXml = new InputSource(xmlFile);
                String query = "//users/user[name/text()='" + username +
                               "' and pass/text()='" + password + "']" +
                               "/secret/text()";
                String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        goodB2G2Private = true;
        goodB2G2Sink(data , request, response);
    }

    private void goodB2G2Sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodB2G2Private)
        {
            String xmlFile = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
            }
            else
            {
                /* running on non-Windows */
                xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
            }
            if (data != null)
            {
                /* assume username||password as source */
                String [] tokens = data.split("||");
                if( tokens.length < 2 )
                {
                    return;
                }
                /* FIX: validate input using StringEscapeUtils */
                String username = StringEscapeUtils.escapeXml(tokens[0]);
                String password = StringEscapeUtils.escapeXml(tokens[1]);
                /* build xpath */
                XPath xPath = XPathFactory.newInstance().newXPath();
                InputSource inputXml = new InputSource(xmlFile);
                String query = "//users/user[name/text()='" + username +
                "' and pass/text()='" + password + "']" +
                "/secret/text()";
                String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2BPrivate = true;
        goodG2BSink(data , request, response);
    }

    private void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodG2BPrivate)
        {
            String xmlFile = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                xmlFile = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";
            }
            else
            {
                /* running on non-Windows */
                xmlFile = "./src/testcases/CWE643_Xpath Injection/CWE643_Xpath_Injection__Helper.xml";
            }
            if (data != null)
            {
                /* assume username||password as source */
                String [] tokens = data.split("||");
                if (tokens.length < 2)
                {
                    return;
                }
                String username = tokens[0];
                String password = tokens[1];
                /* build xpath */
                XPath xPath = XPathFactory.newInstance().newXPath();
                InputSource inputXml = new InputSource(xmlFile);
                /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
                 *     The user input should be canonicalized before validation. */
                /* POTENTIAL FLAW: user input is used without validate */
                String query = "//users/user[name/text()='" + username +
                "' and pass/text()='" + password + "']" +
                "/secret/text()";
                String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
            }
        }
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
