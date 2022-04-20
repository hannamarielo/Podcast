package podcastCRUD.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import podcastCRUD.domain.Category;
import podcastCRUD.domain.CategoryRepository;
import podcastCRUD.domain.PlatformRepository;
import podcastCRUD.domain.Podcast;
import podcastCRUD.domain.PodcastRepository;
import podcastCRUD.domain.SponsorRepository;

@CrossOrigin
@Controller

public class PodcastController {

	@Autowired
	private PodcastRepository podrepository;

	@Autowired
	private CategoryRepository catrepository;

	@Autowired
	private SponsorRepository sponsrepository;

	@Autowired
	private PlatformRepository platrepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/podcastlist")
	public String PodcastList(Model model) {
		model.addAttribute("podcasts", podrepository.findAll());
		return "podcastlist";
	}

	@RequestMapping(value = "/addpodcast")
	public String addPodcast(Model model) {
		model.addAttribute("podcast", new Podcast());
		model.addAttribute("categories", catrepository.findAll());
		model.addAttribute("sponsors", sponsrepository.findAll());
		model.addAttribute("platforms", platrepository.findAll());
		return "addpodcast";
	}

	@RequestMapping(value = "/savepodcast", method = RequestMethod.POST)
	public String savePodcast(Podcast podcast, Category category) {
		catrepository.save(category);
		podrepository.save(podcast);
		return "redirect:podcastlist";
	}

	@RequestMapping(value = "/editpodcast{id}", method = RequestMethod.GET)
	public String editPodcast(@PathVariable("id") Long podcastId, Model model) {
		model.addAttribute("podcast", podrepository.findById(podcastId));
		return "editpodcast";
	}

	@RequestMapping(value = "/editpodcast{id}", method = RequestMethod.POST)
	public String savePodcastError(@Valid BindingResult br) {
		if (br.hasErrors()) {
			return "error";
		} else {
			return "redirect:podcastlist";
		}
	}
	
	@PreAuthorize(value = "hasRole('ADMIN')")
	@RequestMapping(value = "/deletepodcast/{id}", method = RequestMethod.GET)
	public String deletePodcast(@PathVariable("id") Long podcastId, Model model) {
		podrepository.deleteById(podcastId);
		return "redirect:../podcastlist";
	}

	@RequestMapping(value = "/podcasts", method = RequestMethod.GET)
	public @ResponseBody List<Podcast> getPodcastsRest() {
		return (List<Podcast>) podrepository.findAll();
	}

	@RequestMapping(value = "/podcasts/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Podcast> findPodcastsRest(@PathVariable("id") Long podcastId) {
		return podrepository.findById(podcastId);
	}

	@RequestMapping(value = "/podcasts", method = RequestMethod.POST)
	public @ResponseBody Podcast savePodcastRest(@RequestBody Podcast podcast) {
		return podrepository.save(podcast);
	}
}
