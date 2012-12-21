package ColumnPack;

import hudson.Extension;
import hudson.model.Job;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import jenkins.model.Jenkins;

import org.kohsuke.stapler.DataBoundConstructor;

public class InQueueColumn extends ListViewColumn {

    @DataBoundConstructor
    public InQueueColumn() {
        super();
    }

    public String getIcon(@SuppressWarnings("rawtypes") Job build, String subIconSize) {
        if (build == null) {
            return "";
        }
        return build.isInQueue() ? Jenkins.getInstance().getRootUrl() + "plugin/ColumnPack-plugin/" + subIconSize
                + "hourglass.png" : "";
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Build queue status";
        }
    }

}
