package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification {
  
  "Application" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/boum")) must beNone        
      }
    }
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = routeAndCall(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Ready for scala coding!")
      }
    }
    
    "render the configdisplay page" in {
      running(FakeApplication()) {
        val home = routeAndCall(FakeRequest(GET, "/configdisplay")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("my.environment")
      }
    }
    
    "render the homeforms page" in {
      running(FakeApplication()) {
        val home = routeAndCall(FakeRequest(GET, "/homeforms")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("helper.twitterBootstrap")
      }
    }
    
    "render the homeajax page" in {
      running(FakeApplication()) {
        val home = routeAndCall(FakeRequest(GET, "/homeajax")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Ajax")
      }
    }
    
  }
}