package by.modern.controller;

import by.modern.domain.Status;
import by.modern.domain.Voting;
import by.modern.service.StatusService;
import by.modern.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusRestController {
    @Autowired
    private StatusService statusService;
    @Autowired
    private VotingService votingService;

    @RequestMapping(method = RequestMethod.GET, path = "/statuses")
    public List<Status> findAllStatuses() {
        return statusService.findAllStatuses();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/voting")
    public Voting findVoting() {
        return votingService.getVoting();
    }


    /*
    *
    * @Controller
@RequestMapping(value = "/displayImage")
public class ImageDisplayController {

    @Autowired
    private DisplayImageDtoService displayImageDtoService;

    @RequestMapping(value = "/{imageName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> displayImage(@PathVariable String imageName) throws IOException {
        DisplayImageDto image = displayImageDtoService.getDisplayImageDtoByNameImage(imageName);
        return ResponseEntity.ok()
                .contentLength(image.getContentImage().length)
                .contentType(MediaType.parseMediaType(image.getTypeImage()))
                .body(new InputStreamResource(new ByteArrayInputStream(image.getContentImage())));
    }

}
    *
    * */
}
