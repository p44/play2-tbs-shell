package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

case class Home(myval: String)

object Application extends Controller {

  import com.typesafe.config.ConfigFactory

  def index = Action {
    Ok(views.html.index("Ready for scala coding!"))
  }

  def configdisplay = Action {
    Ok(views.html.configdisplay("Settings --> ", listConfig))
  }
  
  val homeForm = Form(
    mapping(
      "myval" -> nonEmptyText.verifying(maxLength(50))
    )(Home.apply)(Home.unapply)
  )
  
  def homeforms = Action {
    Ok(views.html.homeforms("This forms is built with helper.twitterBootstrap._", homeForm))
  }
  
  def homepost = Action { implicit request =>
    homeForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.homeforms("There was a problem with the submission.", formWithErrors)) 
        },
      value => {
        Logger.debug("New value:  " + value)
        Ok(views.html.homeforms("Got the new value, " + value.myval, homeForm))
      }
    )
  }

  def listConfig: List[String] = {
    val conf = ConfigFactory.load
    val r = List[String](
      "my.environment: " + conf.getString("my.environment"))
    r
  }

}