package ColumnPack;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.Run;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.kohsuke.stapler.DataBoundConstructor;

public class LastTriggeredColumn extends ListViewColumn {

    @DataBoundConstructor
    public LastTriggeredColumn() {
        super();
    }

    public String getLabel(@SuppressWarnings("rawtypes") Job build) {
        @SuppressWarnings("rawtypes")
        Run lastBuild = build.getLastBuild();
        return lastBuild != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .format(new Date(lastBuild.getTimeInMillis())) : "N/A";
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Last Triggered";
        }
    }

}
