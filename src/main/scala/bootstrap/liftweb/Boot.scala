package bootstrap.liftweb

import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._

/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("com.mirzov.oleg.website")

	//Build Menus
	val homeMenu = Menu(Loc("Home", List("index"), "Home"))

	val generalCvMenu = Menu(Loc("General info", "cv"::"cvshort#general" :: Nil, "General info"))
	val personalityCvMenu = Menu(Loc("Personality", "cv"::"cvshort#personality" :: Nil, "Personality"))
	val educationCvMenu = Menu(Loc("Education and work", "cv"::"cvshort#education" :: Nil, "Education and work"))

	val shortCvMenu = Menu(	Loc("Short CV", "cv"::"index#" :: Nil, "Short CV"),
							generalCvMenu,
							personalityCvMenu,
							educationCvMenu)

	val clinExpMenu = Menu(Loc("Clinical Studies", "cv"::"experience#clinical" :: Nil, "Clinical Studies"))
	val semwebExpMenu = Menu(Loc("Semantic Web", "cv"::"experience#semweb" :: Nil, "Semantic Web"))
	val webExpMenu = Menu(Loc("Web Development", "cv"::"experience#web" :: Nil, "Web Development"))
	val develExpMenu = Menu(Loc("Software Development", "cv"::"experience#development" :: Nil, "Software Development"))
	val itExpMenu = Menu(Loc("General IT", "cv"::"experience#it" :: Nil, "General IT"))
	val compExpMenu = Menu(Loc("Computations", "cv"::"experience#computations" :: Nil, "Computations"))
	val labExpMenu = Menu(Loc("Lab", "cv"::"experience#lab" :: Nil, "Lab"))
	val teachingExpMenu = Menu(Loc("Teaching", "cv"::"experience#teaching" :: Nil, "Teaching"))
	val otherExpMenu = Menu(Loc("Other", "cv"::"experience#other" :: Nil, "Other"))

	val experienceMenu = Menu(	Loc("Experience", "cv"::"experience" :: Nil, "Experience"),
                develExpMenu,
					 webExpMenu,
                semwebExpMenu,
                clinExpMenu,
								itExpMenu,
								compExpMenu,
								labExpMenu,
								teachingExpMenu,
								otherExpMenu)

	val articlesMenu = Menu(Loc("Articles", "cv"::"publications#articles" :: Nil, "Articles"))
	val thesesMenu = Menu(Loc("Theses", "cv"::"publications#theses" :: Nil, "Theses"))
	val abstractsMenu = Menu(Loc("Abstracts", "cv"::"publications#abstracts" :: Nil, "Abstracts"))

	val publicationsMenu = Menu(Loc("Publications", "cv"::"publications" :: Nil, "Publications"),
								articlesMenu,
								thesesMenu,
								abstractsMenu)

	val achievementsMenu = Menu(Loc("Achievements", "cv"::"achievements" :: Nil, "Achievements"))

	val cvMenu = Menu(	Loc("CV", "cv" :: "index" :: Nil, "CV"),
						shortCvMenu,
                   		experienceMenu,
                   		achievementsMenu,
                   		publicationsMenu)

	val booksMenu = Menu(Loc("Books", "books"::"index" :: Nil, "Books"))
	val linksMenu = Menu(Loc("Links", "links"::"index" :: Nil, "Links"))
	val aboutMenu = Menu(Loc("About", "about"::"index" :: Nil, "About"))

	// Build SiteMap
    val entries =	homeMenu :: cvMenu :: booksMenu :: linksMenu :: aboutMenu :: Nil

    LiftRules.setSiteMap(SiteMap(entries:_*))
  }
}

