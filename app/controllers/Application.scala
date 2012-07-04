package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  import com.typesafe.config.ConfigFactory

  def index = Action {
    Ok(views.html.index("Ready for scala coding!"))
  }

  def configdisplay = Action {
    Ok(views.html.configdisplay("Settings --> ", listConfig))
  }

  def listConfig: List[String] = {
    val conf = ConfigFactory.load
    val r = List[String](
      "my.environment: " + conf.getString("my.environment"))
    r
  }

}