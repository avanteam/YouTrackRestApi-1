package youtrack;

import org.jetbrains.annotations.NotNull;
import org.apache.commons.codec.Charsets;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;

/**
 * Created by egor.malyshev on 07.04.2014.
 */
final class RemoveIssueTag extends RemoveCommand<Issue, IssueTag> {
    RemoveIssueTag(@NotNull Issue owner) {
        super(owner);
    }

    @Override
    HttpRequestBase createMethod() {
        final HttpPost result = new HttpPost(owner.getYouTrack().getHostAddress() + "issue/" + owner.getId() + "/execute");
        result.setEntity(new UrlEncodedFormEntity(Collections.singletonList(new BasicNameValuePair("command", "untag " + item.getTag())), Charsets.toCharset("UTF-8")));
        return result;
    }
}