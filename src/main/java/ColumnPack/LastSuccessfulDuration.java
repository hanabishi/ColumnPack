package ColumnPack;

import hudson.Extension;
import hudson.model.Job;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;

import org.kohsuke.stapler.DataBoundConstructor;

public class LastSuccessfulDuration extends ListViewColumn {

    @DataBoundConstructor
    public LastSuccessfulDuration() {
        super();
    }

    public String getLastSuccessfulDuration(@SuppressWarnings("rawtypes") Job build) {
        if (build.getLastSuccessfulBuild() == null) {
            return "N/A";
        }
        return build.getLastSuccessfulBuild().getDurationString();
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Last successful duration";
        }
    }

}
