package jenkins.plugins.svnmerge.IntegratableProjectAction

def f = namespace(lib.FormTagLib.class)
def l = namespace(lib.LayoutTagLib.class)
def st = namespace("jelly:stapler")

st.statusCode(value:400) // this should be an error page
l.layout (norefresh:true, title:"Feature Branches of ${my.project.displayName}") {
    include(my.project,"sidepanel")
    l.main_panel {
        h1 {
            img (src:"${imagesURL}/48x48/error.png")
            text(_("Error"))
        }

        p {
            form (name:"new", method:"post", action:"newBranch") {
                def n = request.getParameter('name')
                raw(_("attachTest", n))
                input(type:"hidden",name:"name", value:n)
                input(type:"hidden",name:"attach", value:"true")

                f.submit(value:_("Yes"))
            }
        }
    }
}
